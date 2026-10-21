
package LaunchAi;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.Response;

public class openAiSdk {

    public static void main(String[] args) {

        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input("what is java in 1 word")
                .model("gpt-5.6-luna")
                .build();

        Response response = client.responses().create(params);

        response.output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .forEach(outputText ->
                        System.out.println(outputText.text())
                );
    }
}
