/*
 * Copyright (c) 2023, The Dattack team (http://www.dattack.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dattack.time.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * The controller of the time service.
 *
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/time")
public class TimeController {

    /**
     * Returns the current date and time at the specified time zone.
     *
     * @param timeZone the time zone
     * @return the current date and time at the specified time zone
     */
    @GetMapping(produces = "application/json")
    public TimeResponse getDateTime(@RequestParam(name = "timeZone", required = false) final String timeZone) {

        ZoneId utc = ZoneId.of("UTC");
        ZonedDateTime utcDateTime = ZonedDateTime.now(utc);
        if (timeZone == null) {
            return new TimeResponse(utcDateTime, utc, utcDateTime);
        }
        ZoneId targetZoneId = ZoneId.of(timeZone);
        ZonedDateTime targetDateTime = utcDateTime.withZoneSameInstant(targetZoneId);
        return new TimeResponse(utcDateTime, targetZoneId, targetDateTime);
    }
}
