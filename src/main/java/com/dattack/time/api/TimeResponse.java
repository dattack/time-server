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

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * The response of the time service.
 *
 * @since 0.0.1
 */
public class TimeResponse {

    /** The UTC date and time. */
    private final ZonedDateTime utc;

    /** The target time zone. */
    private final ZoneId timeZone;

    /** The target date and time. */
    private final ZonedDateTime dateTime;

    /**
     * Constructor.
     *
     * @param utc the UTC date and time
     * @param timeZone the target time zone
     * @param dateTime the target date and time
     */
    public TimeResponse(ZonedDateTime utc, ZoneId timeZone, ZonedDateTime dateTime) {
        this.utc = utc;
        this.timeZone = timeZone;
        this.dateTime = dateTime;
    }

    /**
     * Returns the UTC date and time.
     *
     * @return the UTC date and time
     */
    public ZonedDateTime getUtc() {
        return utc;
    }

    /**
     * Returns the target time zone.
     *
     * @return the target time zone
     */
    public ZoneId getTimeZone() {
        return timeZone;
    }

    /**
     * Returns the target date and time.
     *
     * @return the target date and time
     */
    public ZonedDateTime getDateTime() {
        return dateTime;
    }
}
