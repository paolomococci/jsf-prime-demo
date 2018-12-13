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

import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationScopeMetadataResolver
import org.springframework.context.annotation.ScopeMetadata
import org.springframework.context.annotation.ScopeMetadataResolver
import org.springframework.context.annotation.ScopedProxyMode

class SessionScope : AnnotationScopeMetadataResolver(), ScopeMetadataResolver {

    override fun resolveScopeMetadata(definition: BeanDefinition): ScopeMetadata {
        val scopeMetadata = super.resolveScopeMetadata(definition)
        val scopeName = scopeMetadata.scopeName
        if (scopeName == ScopeName.SESSION || scopeName == ScopeName.VIEW) {
            scopeMetadata.scopedProxyMode = ScopedProxyMode.TARGET_CLASS
        }
        return scopeMetadata
    }
}
