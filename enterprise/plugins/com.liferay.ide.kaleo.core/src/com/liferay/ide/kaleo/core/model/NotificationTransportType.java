/**
 * Copyright (c) 2014 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the End User License
 * Agreement for Liferay IDE ("License"). You may not use this file
 * except in compliance with the License. You can obtain a copy of the License
 * by contacting Liferay, Inc. See the License for the specific language
 * governing permissions and limitations under the License, including but not
 * limited to distribution rights of the Software.
 */

package com.liferay.ide.kaleo.core.model;

import org.eclipse.sapphire.modeling.annotations.EnumSerialization;
import org.eclipse.sapphire.modeling.annotations.Label;

/**
 * @author Gregory Amerson
 */
@Label( standard = "notification transport type" )
public enum NotificationTransportType
{

    @Label( standard = "email" )
    @EnumSerialization( primary = "email" )
    EMAIL,

    @Label( standard = "im" )
    @EnumSerialization( primary = "im" )
    IM,

    @Label( standard = "private message" )
    @EnumSerialization( primary = "private-message" )
    PRIVATE_MESSAGE,

}
