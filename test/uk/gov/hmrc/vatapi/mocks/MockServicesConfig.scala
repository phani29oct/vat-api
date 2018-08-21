/*
 * Copyright 2018 HM Revenue & Customs
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

package uk.gov.hmrc.vatapi.mocks

import com.typesafe.config.Config
import org.mockito.stubbing.OngoingStubbing
import org.scalatest.Suite
import uk.gov.hmrc.play.config.inject.ServicesConfig

trait MockServicesConfig extends Mock { _: Suite =>

  val mockServicesConfig: ServicesConfig = mock[ServicesConfig]
  val mockConfig: Config = mock[Config]

  object MockedServicesConfig {
    def getBoolean(key: String): OngoingStubbing[Boolean] = when(mockServicesConfig.getBoolean(eqTo(key)))
  }

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    reset(mockServicesConfig)
  }
}