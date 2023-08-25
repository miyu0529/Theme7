package Theme7.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
public class NameController {
    @GetMapping("/names")
    public List<Name> getNames(@RequestParam(value = "givenName", required = false) String givenName, @RequestParam(value = "firstName", required = false) String firstName) {
        //return givenName + firstName;
        return List.of(new Name("taichi", "yagami"), new Name("hikari", "yagami"));
    }


    @PostMapping("/names")
    public ResponseEntity<Map<String, String>> create(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> dalete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }

}
