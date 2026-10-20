package com.priya.springAIOllamaDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin("*")
public class OllamaController {

    //1
//    private OllamaChatModel chatModel;
//    public OllamaController(OllamaChatModel chatModel){
//        this.chatModel = chatModel;
//    }

    //2
    private ChatClient chatClient; //here adding one more layer of abstraction and didn't mention what model we using...
    public OllamaController(OllamaChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel); //here for chatClient we passing the ollama chatmodel's obj...
                                                        //to specify the model is ollama...
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){

        //1
//        String response = chatModel.call(message);
//        return ResponseEntity.ok(response);

        //2
//        String response = chatClient.prompt(message)
//                                    .call()
//                                    .content(); //calling the prompt... // we need answer from model as String so used content()
//        return ResponseEntity.ok(response);


        //3 ==>> need to work with metadata of LLM models use chatResponse()...
        ChatResponse chatResponse = chatClient.prompt(message)
                .call()
                .chatResponse();
        System.out.println(chatResponse.getMetadata().getModel()); //to print the which model this LLM belongs to...
        String response = chatResponse.getResult().getOutput().getText(); //convert chatResponse to String format...
        return ResponseEntity.ok(response);
    }

}
