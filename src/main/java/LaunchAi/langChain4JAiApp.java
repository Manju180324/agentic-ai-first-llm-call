package LaunchAi;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatRequestParameters;
import dev.langchain4j.model.openai.internal.OpenAiClient;

public class langChain4JAiApp {
    public static void main(String[] args) {

        SystemMessage systemMessage = SystemMessage.systemMessage(""+ "act like java trainer");

        UserMessage userQuestion = UserMessage.userMessage("What is java tell me in a sentence");

        ChatModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("API_KEY"))
                .modelName("gpt-5.6-luna")
                .build();

//        String answer = model.chat("can you explain java in simpler terms?");
//        System.out.println(answer);

        ChatResponse response = model.chat(systemMessage, userQuestion);
        System.out.println(response.aiMessage().text());
    }
}
