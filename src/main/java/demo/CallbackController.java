package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by kkujovic on 4/12/15.
 */
@RestController
@RequestMapping("/callback")
public class CallbackController {
    private static final Logger log = LoggerFactory.getLogger(CallbackController.class);

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> receiveNotification(@RequestBody Map<String, ?> values) {

        values.entrySet().stream().forEach(entry ->
            log.info("Key {}, value {}", entry.getKey(), entry.getValue())
        );

        return ResponseEntity.ok().build();
    }
}
