package com.soebes.maven.plugins.tmp;

import java.util.jar.Manifest;

import javax.inject.Inject;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * Will check dependencies of your project and fail the build if they are not up-to-date.
 * 
 * @author Karl-Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 */
@Mojo( name = "test", defaultPhase = LifecyclePhase.NONE, requiresProject = true, threadSafe = true )
public class TestMojo
    extends AbstractUpToDateMojo
{

	@Parameter(defaultValue = "${project}", required = true, readonly = true) 
	private MavenProject project;
	
	@Parameter
	private String conf;
	
	@Inject
	private LifeCycleParticipant deploy;
	
	public void execute()
        throws MojoExecutionException, MojoFailureException
    {

        if ( isSkip() )
        {
            getLog().info( " Skipping execution based on user request." );
            return;
        }

//        deploy.setConf(conf);
    }


}
