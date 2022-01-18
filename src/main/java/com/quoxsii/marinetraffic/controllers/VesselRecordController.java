package com.quoxsii.marinetraffic.controllers;

import com.quoxsii.marinetraffic.services.VesselRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vessels_records")
public class VesselRecordController {
    @Autowired
    private VesselRecordService recordService;
}
