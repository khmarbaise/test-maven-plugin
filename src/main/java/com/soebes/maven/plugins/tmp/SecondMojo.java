package com.soebes.maven.plugins.tmp;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Will check dependencies of your project and fail the build if they are not up-to-date.
 * 
 * @author Karl-Heinz Marbaise <a href="mailto:khmarbaise@apache.org">khmarbaise@apache.org</a>
 */
@Mojo( name = "second", defaultPhase = LifecyclePhase.NONE, requiresProject = true, threadSafe = true )
public class SecondMojo
    extends AbstractTestMojo
{

    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
        getLog().info( "This is goal: second" );

    }

}
