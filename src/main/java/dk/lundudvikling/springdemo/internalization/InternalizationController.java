package dk.lundudvikling.springdemo.internalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("internalization")
public class InternalizationController {

    private MessageTranslator messageTranslator;

    @Autowired
    public InternalizationController(MessageTranslator messageTranslator) {
        this.messageTranslator = messageTranslator;
    }

    @GetMapping("{languageCode}/{text}")
    public ResponseEntity<String> getInternalizedText(@PathVariable String languageCode, @PathVariable String text){
        return new ResponseEntity<>(messageTranslator.getInternalizedString(text, languageCode), HttpStatus.OK);
    }
}
