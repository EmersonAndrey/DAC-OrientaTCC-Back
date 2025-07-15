package dac.orientaTCC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dac.orientaTCC.model.dto.TrabalhoAcademicoTCCCreateDTO;
import dac.orientaTCC.model.dto.TrabalhoAcademicoTCCResponseDTO;
import dac.orientaTCC.service.TrabalhoAcademicoTCCService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/trabalhoAcademico")
public class TrabalhoAcademicoTCCController {

    private final TrabalhoAcademicoTCCService trabalhoAcademicoTCCService;

    @PostMapping("/save")
    public ResponseEntity<TrabalhoAcademicoTCCResponseDTO> save(@RequestBody TrabalhoAcademicoTCCCreateDTO dto){
        TrabalhoAcademicoTCCResponseDTO response = trabalhoAcademicoTCCService.save(dto);
        return null;
    }
}
