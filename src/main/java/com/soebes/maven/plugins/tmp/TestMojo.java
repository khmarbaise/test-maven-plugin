package com.soebes.maven.plugins.tmp;

import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Will check dependencies of your project and fail the build if they are not up-to-date.
 * 
 * @author Karl-Heinz Marbaise <a href="mailto:khmarbaise@soebes.de">khmarbaise@soebes.de</a>
 */
@Mojo( name = "test", defaultPhase = LifecyclePhase.NONE, requiresProject = true, threadSafe = true )
public class TestMojo
    extends AbstractUpToDateMojo
{

    /**
     * Define the list of dependencies you would like check if they are up-to-date. If this list is not defined or empty
     * the plugin will check all project dependencies.
     */
    @Parameter
    private List<Dependency> dependencies;

    public void execute()
        throws MojoExecutionException, MojoFailureException
    {

        if ( isSkip() )
        {
            getLog().info( " Skipping execution based on user request." );
            return;
        }


    }


}
