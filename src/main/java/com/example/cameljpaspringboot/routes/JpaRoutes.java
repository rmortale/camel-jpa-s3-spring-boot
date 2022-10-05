package com.example.cameljpaspringboot.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.s3.AWS2S3Constants;
import org.springframework.stereotype.Component;

@Component
public class JpaRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//       /* rest()
//                .get("book/{id}").description("Details of an book by id")
//                .outType(Book.class)
//                .produces(MediaType.APPLICATION_JSON_VALUE)
//                .route()*/

//        from("timer:new-order?delay=1000&period={{example.generateOrderPeriod:20000}}")
//                .transacted()
//                .routeId("generate-order")
//                .bean("bookService", "generateBook")
//                .to("jpa:com.example.cameljpaspringboot.domain.Book")
//                .throwException(new RuntimeException("test"))
//                .log("Inserted new order ${body.id}");

        from("timer:new-order?delay=1000&period={{example.generateOrderPeriod:20000}}")
                .to("direct:s3download");

        from("direct:s3download")
                .setHeader(AWS2S3Constants.KEY, constant("docker-compose.yml"))
                .to("aws2-s3:event-example-bucket?operation=getObject")
                .to("log:s3-log")
                .to("file:s3-download");
    }
}
