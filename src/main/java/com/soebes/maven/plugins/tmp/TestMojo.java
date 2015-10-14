package com.soebes.maven.plugins.tmp;

import javax.inject.Inject;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Will check dependencies of your project and fail the build if they are not up-to-date.
 * 
 * @author Karl-Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 */
@Mojo(name = "test", defaultPhase = LifecyclePhase.NONE, requiresProject = true, threadSafe = true)
public class TestMojo
    extends AbstractTestMojo
{

    @Parameter
    private String conf;

    @Inject
    private LifeCycleParticipant deploy;

    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
        //FIXME: Little trick to identify the correct instance..
        deploy.setMojo( this );

        if ( isSkip() )
        {
            getLog().info( " Skipping execution based on user request." );
            return;
        }

        getLog().info( "Participant: " + deploy );
        deploy.setConf( conf );
    }

}
