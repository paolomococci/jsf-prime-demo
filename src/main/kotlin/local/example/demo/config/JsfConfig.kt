/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.config

import com.sun.faces.config.ConfigureListener
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.ServletContextAware

import javax.faces.webapp.FacesServlet
import javax.servlet.ServletContext
import javax.servlet.ServletException

@Configuration
class JsfConfig : SpringBootServletInitializer(), ServletContextAware {

    @Throws(ServletException::class)
    override fun onStartup(servletContext: ServletContext) {
        super.onStartup(servletContext)
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true")
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development")
    }

    @Bean
    fun facesServlet(): ServletRegistrationBean<*> {
        val servlet = FacesServlet()
        val registration = ServletRegistrationBean(servlet, "*.xhtml")
        registration.setName("FacesServlet")
        registration.setLoadOnStartup(1)
        return registration
    }

    @Bean
    fun jsfConfigureListener(): ServletListenerRegistrationBean<ConfigureListener> {
        return ServletListenerRegistrationBean(ConfigureListener())
    }

    override fun setServletContext(servletContext: ServletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", java.lang.Boolean.TRUE.toString())
    }
}
