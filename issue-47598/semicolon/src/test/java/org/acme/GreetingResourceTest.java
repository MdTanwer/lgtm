package org.acme;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @TestHTTPResource
    String uri;

    @Test
    void testHelloEndpoint() {
        given()
                .urlEncodingEnabled(false)
          .when()
                .log().all().get("/ex;m1;m2=foo?q1&q2=bar")
          .then()
                .log().all()
             .statusCode(200)
             .body(is("ex: "+uri+"ex?q1&q2=bar m1: null m2: foo q1: null q2: bar query params: {q1=[], q2=[bar]} segments: [ex;m2=foo] matrix params: {m1=[], m2=[foo]}"));
    }

}