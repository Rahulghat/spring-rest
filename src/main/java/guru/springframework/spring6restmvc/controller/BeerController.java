package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/beer")
public class BeerController {
    private final BeerService beerService;

    @PutMapping("/api/v1/beer/{beerid}")
    public ResponseEntity updateBeer(@RequestBody Beer beer, @PathVariable("beerid") UUID beerid ){
        Beer beer1 = beerService.updateBeerbyid(beer, beerid);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", beer1.getId() + "Updated");
        return new ResponseEntity(header,HttpStatus.OK);
    }


    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    @PostMapping("/api/v1/beer")
    public ResponseEntity addBeer(@RequestBody  Beer beer) {
        Beer savedbeer = this.beerService.saveBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer" + savedbeer.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/v1/beer/{id}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("id") UUID id) {

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(id);
    }

}
