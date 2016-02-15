package com.soebes.maven.plugins.tmp;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

public abstract class AbstractTestMojo
    extends AbstractMojo
{

    /**
     * The project currently being build.
     */
    @Parameter( defaultValue = "${project}", readonly = true )
    private MavenProject mavenProject;

    /**
     * The current Maven session.
     */
    @Parameter( defaultValue = "${session}", readonly = true )
    private MavenSession mavenSession;

    public MavenProject getMavenProject()
    {
        return mavenProject;
    }

    public MavenSession getMavenSession()
    {
        return mavenSession;
    }

}
