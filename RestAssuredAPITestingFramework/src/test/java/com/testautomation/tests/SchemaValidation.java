package com.testautomation.tests;

import java.net.http.HttpResponse.BodyHandler;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class SchemaValidation {

	@Test
	public void schemaValidationTest() {

		// use to conver json to json schema -
		// https://www.liquid-technologies.com/online-json-to-schema-converter

		RestAssured.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat()
		.statusCode(200)
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidationfile.json"));
	}

}
