package com.soebes.maven.plugins.tmp;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.project.MavenProject;
import org.apache.maven.repository.RepositorySystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Named
public class DeployAtParticularPosition extends AbstractMavenLifecycleParticipant {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	private RepositorySystem system;

	@Inject
	public DeployAtParticularPosition(RepositorySystem system) {
		LOGGER.info("DeployAtParticularPosition(ctro)");
		this.system = system;
	}

	@Override
	public void afterProjectsRead(MavenSession session) {
		LOGGER.info("afterProjectsRead()");
		LOGGER.info(" -> " + session.getCurrentProject().getId());
	}

	@Override
	public void afterSessionStart(MavenSession session) {
		LOGGER.info("afterSessionStart()");
	}

	@Override
	public void afterSessionEnd(MavenSession session) throws MavenExecutionException {
		LOGGER.info("afterSessionEnd(start)");
		MavenProject project = session.getProjects().get(0);

		if (!project.hasLifecyclePhase(LifecyclePhase.DEPLOY.id())) {
			return;
		}

		for (MavenProject p : session.getProjectDependencyGraph().getSortedProjects()) {
			LOGGER.info("-> Project:" + p.getId());
		}
		LOGGER.info("afterSessionEnd(end)");
	}

}
