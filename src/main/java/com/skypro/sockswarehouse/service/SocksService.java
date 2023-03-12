package com.skypro.sockswarehouse.service;

import com.skypro.sockswarehouse.model.Socks;
import com.skypro.sockswarehouse.repository.SocksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocksService {
    private final SocksRepository socksRepository;

    public SocksService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    public Socks postSocksIncome(Socks socks) {
        Socks foundSocks = socksRepository.findByColorAndCottonPart(socks.getColor(), socks.getCottonPart());

        if (foundSocks == null) {
            return socksRepository.save(socks);
        }

        foundSocks.setQuantity(foundSocks.getQuantity() + socks.getQuantity());
        return socksRepository.save(foundSocks);
    }

    public Socks postSocksOutcome(Socks socks) {
        System.out.println(1);
        Socks foundSock = socksRepository.findByColorAndCottonPart(socks.getColor(), socks.getCottonPart());
        if (foundSock == null || socks.getQuantity() > foundSock.getQuantity()) {
            return null;
        }

        foundSock.setQuantity(foundSock.getQuantity() - socks.getQuantity());
        System.out.println(foundSock.toString());

        return socksRepository.save(foundSock);
    }

    public List<Socks> getSocks(String color, String operation, int cottonPart) {
        if (operation.equals("moreThan")) {
            return socksRepository.findByColorAndCottonPartGreaterThan(color, cottonPart);
        }
        else if (operation.equals("lessThan")) {
            return socksRepository.findByColorAndCottonPartLessThan(color, cottonPart);
        }
        else  if (operation.equals("equals")) {
            return socksRepository.findByColorAndCottonPartEquals(color, cottonPart);
        }
        else {
            return null;
        }
    }
}
