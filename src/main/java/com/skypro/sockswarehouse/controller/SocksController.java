package com.skypro.sockswarehouse.controller;

import com.skypro.sockswarehouse.model.Socks;
import com.skypro.sockswarehouse.service.SocksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SocksController {
    private final Logger logger = LoggerFactory.getLogger(SocksController.class);

    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping("/socks/income")
    ResponseEntity<Socks> incomeSocks(@RequestBody Socks socks) {
        logger.info("income invoked");

        if (socks.getCottonPart() > 100 || socks.getCottonPart() < 0 || socks.getQuantity() < 0) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(socksService.postSocksIncome(socks));
    }

    @PostMapping("/socks/outcome")
    ResponseEntity<Socks> outcomeSocks(@RequestBody Socks socks) {
        logger.info("outcome invoked");

        if (socks.getCottonPart() > 100 || socks.getCottonPart() < 0 || socks.getQuantity() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(socksService.postSocksOutcome(socks));
    }

    @GetMapping("/socks")
    ResponseEntity<Collection<Socks>> getSocks(@RequestParam String color, @RequestParam String operation,
                                               @RequestParam int cottonPart) {
        logger.info("getSocks invoked");
        List<Socks> res = socksService.getSocks(color, operation, cottonPart);

        if (cottonPart > 100 || cottonPart < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

}
