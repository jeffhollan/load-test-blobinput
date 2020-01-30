package com.hollan.functions;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    @FunctionName("HttpTrigger-Java")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            @BlobInput(name = "inputDoc", connection = "AzureWebJobsStorage", path = "input/blobInput.json") String payload,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        context.getLogger().info("blob length: " + payload.length());

        return request.createResponseBuilder(HttpStatus.OK)
        .header("Content-Type", "application/json")
        .body(payload)
        .build();
    }
}
