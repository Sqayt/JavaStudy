package ru.ivanovds.ChatGPT;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class OpenAiApiExample {
    public static void main(String[] args) {
        String token = System.getenv("OPENAI_TOKEN");
        OpenAiService service = new OpenAiService(token);

        System.out.println("\nCreating completion...");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("ada")
                .prompt("Somebody once told me the world is gonna roll me")
                .echo(true)
                .user("testing")
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(
                it -> System.out.println(it + " ")
        );
    }
}
