package eci.qa.zephyr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eci.qa.appium.Base;
import eci.qa.appium.Constantes;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ZephyrUtilities {

	private ZephyrUtilities() {
	}

	public static void cleanAttachments(int issueId) {

		try {

			RequestSpecification issueIdRequest = getRequestConfigured();

			int cycle = getCycleId(Base.getProperty("NAME_CYCLE"), Base.getProperty("RELEASE_VERSION"));
			int executionId = getExecutionId(issueId, cycle);

			String issueEndpoint = "https://jira.almeci.io/rest/zapi/latest/attachment/attachmentsByEntity?entityId="
					+ executionId + "&entityType=execution";

			ResponseBody<?> cycleId = issueIdRequest.get(issueEndpoint).getBody();
			int numAttachments = cycleId.jsonPath().getList("data").size();

			if (numAttachments > 0) {

				List<String> ids = new ArrayList<String>();
				for (int i = 0; i < numAttachments; i++) {
					Map<String, String> mapsd = (Map<String, String>) cycleId.jsonPath().getList("data").get(i);
					ids.add(mapsd.get("fileId").toString());
				}

				for (String att : ids) {
					String issueEndpointDelete = "https://jira.almeci.io/rest/zapi/latest/attachment/" + att;
					issueIdRequest.delete(issueEndpointDelete);

				}
			}
		} catch (Exception e) {
			System.out.println("Error al conectar test con Zephyr");
		}
	}

	public static void addComentary(int issueId, String commentary) {

		Map<String, String> body = new HashMap<>();
		body.put("comment", commentary + " AMBIENTE: " + Base.getProperty("AMBIENTE") + " SISTEMA OPERATIVO: "
				+ Base.getProperty("SO"));

		int cycleId = getCycleId(Base.getProperty("NAME_CYCLE"), Base.getProperty("RELEASE_VERSION"));
		int executionId = getExecutionId(issueId, cycleId);

		RequestSpecification issueIdRequest = getRequestConfigured();
		issueIdRequest.body(body);
		String issueEndpoint = "https://jira.almeci.io/rest/zapi/latest/execution/" + executionId + "/execute";

		issueIdRequest.put(issueEndpoint).getBody();

	}

	public static void addAttachment(int issueId) throws IOException {
		RequestSpecification issueIdRequest = getRequestConfigured();

		int cycleId = getCycleId(Base.getProperty("NAME_CYCLE"), Base.getProperty("RELEASE_VERSION"));
		int executionId = getExecutionId(issueId, cycleId);

		String issueEndpoint = "https://jira.almeci.io/rest/zapi/latest/attachment?entityId=" + executionId
				+ "&entityType=execution";
		File screen = Base.getScreenshot();

		issueIdRequest.header(new Header("content-type", "multipart/form-data")).multiPart("file", screen)
				.formParam("description", "screenshot").post(issueEndpoint).getBody();

	}

	public static void updateZephyr(int issueId, String status) {
		sendResultsJIRA(issueId, status, Base.getProperty("NAME_CYCLE"), Base.getProperty("RELEASE_VERSION"));
	}

	private static void sendResultsJIRA(int issueId, String status, String cycleName, String version) {
		int cycleId = getCycleId(cycleName, version);

		Map<String, String> body = new HashMap<>();
		body.put("status", status);

		int executionId = getExecutionId(issueId, cycleId);
		if (executionId != 0) {
			RequestSpecification issueIdRequest = getRequestConfigured();
			issueIdRequest.body(body);
			String issueEndpoint = "https://jira.almeci.io/rest/zapi/latest/execution/" + executionId + "/execute";

			issueIdRequest.put(issueEndpoint).getBody();
		}
	}

	private static int getExecutionId(int issueType, int cycle) {
		RequestSpecification issueIdRequest = getRequestConfigured();
		String issueEndpoint = "http://jira.almeci.io/rest/zapi/latest/execution?cycleId=" + cycle
				+ "&limit=30&offset=0";

		ResponseBody<?> cycleId = issueIdRequest.get(issueEndpoint).getBody();

		int sizeOfResponse = cycleId.jsonPath().getList(Constantes.EXECUTIONS).size();

		for (int i = 0; i < sizeOfResponse; i++) {
			Map<String, ?> mapsd = (Map<String, ?>) cycleId.jsonPath().getList(Constantes.EXECUTIONS).get(i);
			if (mapsd.get("issueId").equals(issueType)) {
				return (int) mapsd.get("id");
			}
		}
		return 0;
	}

	private static int getCycleId(String cycleName, String version) {
		RequestSpecification issueIdRequest = getRequestConfigured();
		String issueEndpoint = "https://jira.almeci.io/rest/zapi/latest/zql/executeSearch?zqlQuery=cycleName = '"
				+ cycleName + "' AND fixVersion = " + version;

		ResponseBody<?> cycleId = issueIdRequest.get(issueEndpoint).getBody();

		System.out.println(cycleId.asString());

		Map<String, ?> mapsd = (Map<String, ?>) cycleId.jsonPath().getList(Constantes.EXECUTIONS).get(0);
		return (int) mapsd.get("cycleId");
	}

	private static RequestSpecification getRequestConfigured() {
		RequestSpecification issueIdRequest = RestAssured.given();
		issueIdRequest.header("Content-Type", Constantes.CONTENT_TYPE);
		issueIdRequest.header("Authorization", Constantes.AUTHORIZATION);
		return issueIdRequest;
	}
}
