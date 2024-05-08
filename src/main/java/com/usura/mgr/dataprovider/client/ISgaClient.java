package com.usura.mgr.dataprovider.client;

import com.usura.mgr.dto.EstudianteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${client.SGA.url}",name = "SGA")
public interface ISgaClient {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstudianteDto> consultarEstudiante(@RequestParam("documento") String documento);



    }
