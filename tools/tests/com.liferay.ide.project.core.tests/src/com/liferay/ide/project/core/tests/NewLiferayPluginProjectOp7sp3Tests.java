/*******************************************************************************
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 *******************************************************************************/

package com.liferay.ide.project.core.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import com.liferay.ide.core.util.CoreUtil;
import com.liferay.ide.project.core.ProjectCore;
import com.liferay.ide.project.core.model.NewLiferayPluginProjectOp;
import com.liferay.ide.project.core.model.PluginType;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.platform.PathBridge;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Terry Jia
 */
public class NewLiferayPluginProjectOp7sp3Tests extends NewLiferayPluginProjectOpBase
{

    @Override
    protected IPath getLiferayPluginsSdkDir()
    {
        return ProjectCore.getDefault().getStateLocation().append(
            "com.liferay.portal.plugins.sdk-1.0.16-withdependencies" );
    }

    @Override
    protected IPath getLiferayPluginsSDKZip()
    {
        return getLiferayBundlesPath().append(
            "com.liferay.portal.plugins.sdk-1.0.16-withdependencies.zip" );
    }

    @Override
    protected String getLiferayPluginsSdkZipFolder()
    {
        return "com.liferay.portal.plugins.sdk-1.0.16-withdependencies/";
    }

    @AfterClass
    public static void removePluginsSDK() throws Exception
    {
        deleteAllWorkspaceProjects();
    }

    @Override
	protected IPath getLiferayRuntimeDir()
    {
        return ProjectCore.getDefault().getStateLocation().append( "liferay-ce-portal-7.0-ga4/tomcat-8.0.32" );
    }

    @Override
	protected IPath getLiferayRuntimeZip()
    {
        return getLiferayBundlesPath().append( "liferay-ce-portal-tomcat-7.0-ga4-20170613175008905.zip" );
    }

    @Override
	public String getRuntimeVersion()
    {
        return "7.0.2";
    }

    @Override
    protected String getServiceXmlDoctype()
    {
        return "service-builder PUBLIC \"-//Liferay//DTD Service Builder 7.0.0//EN\" \"http://www.liferay.com/dtd/liferay-service-builder_7_0_0.dtd";
    }

    @Override
    @Test
    @Ignore
    public void testLocationListener() throws Exception
    {
    }

    @Override
    @Test
    @Ignore
    public void testNewJsfRichfacesProjects() throws Exception
    {
    }

    @Override
    @Test
    @Ignore
    public void testNewLayoutAntProject() throws Exception
    {
    }

    @Test
    @Ignore
    public void testNewProjectCustomLocationPortlet() throws Exception
    {
    }

    @Test
    @Ignore
    public void testNewProjectCustomLocationWrongSuffix() throws Exception
    {
    }

    @Test
    @Ignore
    public void testNewSDKProjectCustomLocation() throws Exception
    {
    }

    @Test
    @Ignore
    public void testNewSDKProjectEclipseWorkspace() throws Exception
    {
    }

    @Override
    @Test
    @Ignore
    public void testNewSDKProjectInSDK() throws Exception
    {
    }

    @Ignore
    @Override
    @Test
    public void testNewThemeProjects() throws Exception
    {
        if( shouldSkipBundleTests() )
            return;

        super.testNewThemeProjects();
    }

    @Override
	@Test
    @Ignore
    public void testNewJsfAntProjects() throws Exception
    {
    }

    @Override
    @Test
    @Ignore
    public void testPluginTypeListener() throws Exception
    {
    }

    @Test
    @Ignore
    public void testProjectNameValidation() throws Exception
    {
    }

    @Override
    @Test
    @Ignore
    public void testNewSDKProjects() throws Exception
    {
    }

    @Test
    @Ignore
    public void testNewWebAntProjectValidation() throws Exception
    {
    }

    @Test
    public void testNewExtAntProjectNotSupportedWithWorkspaceSDK() throws Exception
    {
        if( shouldSkipBundleTests() )
            return;

        final String projectName = "test-ext-project-sdk";
        final NewLiferayPluginProjectOp op = newProjectOp( projectName );

        op.setPluginType( PluginType.ext );
        op.setSdkLocation( PathBridge.create( getLiferayPluginsSdkDir() ) );
        Status validation = op.validation();
        assertEquals( true, validation.ok() );

        final IProject extProject = createAntProject( op );

        assertNotNull( extProject );
    }

    @BeforeClass
    public static void removeAllProjects() throws Exception
    {
        IProgressMonitor monitor = new NullProgressMonitor();

        for( IProject project : CoreUtil.getAllProjects() )
        {
            project.delete( true, monitor );

            assertFalse( project.exists() );
        }
    }

}
