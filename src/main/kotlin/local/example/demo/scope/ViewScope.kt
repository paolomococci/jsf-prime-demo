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

package local.example.demo.scope

import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.config.Scope

import javax.faces.context.FacesContext

class ViewScope : Scope {

    override fun get(name: String, objectFactory: ObjectFactory<*>): Any {
        val viewMap = FacesContext.getCurrentInstance().viewRoot.viewMap
        if (viewMap.containsKey(name)) {
            return viewMap[name]!!
        } else {
            val `object` = objectFactory.getObject()
            viewMap[name] = `object`
            return `object`
        }
    }

    override fun remove(name: String): Any? {
        return FacesContext.getCurrentInstance().viewRoot.viewMap.remove(name)
    }

    override fun registerDestructionCallback(name: String, callback: Runnable) {}

    override fun resolveContextualObject(key: String): Any? {
        return null
    }

    override fun getConversationId(): String? {
        return null
    }
}
