/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.bean

import local.example.demo.scope.ScopeName
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

import javax.faces.application.FacesMessage
import javax.faces.context.FacesContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
@Scope(ScopeName.VIEW)
class TimeInfoBean {

    fun timeInfo() {
        FacesContext.getCurrentInstance()
                .addMessage(
                        null,
                        FacesMessage(
                                FacesMessage.SEVERITY_INFO,
                                "Time Info: ",
                                LocalDateTime.now()
                                        .format(DateTimeFormatter
                                                .ofPattern("dd.MM.yyyy HH:mm:ss"))
                        ))
    }
}
