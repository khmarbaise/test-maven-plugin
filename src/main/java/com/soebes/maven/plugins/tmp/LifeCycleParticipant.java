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
@Named("lifeobserver")
public class LifeCycleParticipant extends AbstractMavenLifecycleParticipant {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	private RepositorySystem system;

	private String conf;

	public void setConf(String conf) {
		this.conf = conf;
	}

	public RepositorySystem getSystem() {
		return system;
	}

	public void setSystem(RepositorySystem system) {
		this.system = system;
	}

	@Inject
	public LifeCycleParticipant(RepositorySystem system) {
		LOGGER.info("LifeCycleParticipant::LifeCycleParticipant(ctro) {}", this);
		this.system = system;
	}

	@Override
	public void afterProjectsRead(MavenSession session) {
		LOGGER.info("LifeCycleParticipant::afterProjectsRead() {}", this);
		LOGGER.info("LifeCycleParticipant::afterProjectsRead() value:{}", conf);
		LOGGER.info(" -> " + session.getCurrentProject().getId());
	}

	@Override
	public void afterSessionStart(MavenSession session) {
		LOGGER.info("LifeCycleParticipant::afterSessionStart() {}", this);
		LOGGER.info("LifeCycleParticipant::afterSessionStart() value:" + conf);
	}

	@Override
	public void afterSessionEnd(MavenSession session) throws MavenExecutionException {
		LOGGER.info("LifeCycleParticipant::afterSessionEnd(start)");
		LOGGER.info("LifeCycleParticipant::afterSessionEnd() value:" + conf);
		MavenProject project = session.getProjects().get(0);

		if (!project.hasLifecyclePhase(LifecyclePhase.DEPLOY.id())) {
			return;
		}

		for (MavenProject p : session.getProjectDependencyGraph().getSortedProjects()) {
			LOGGER.info("-> Project:" + p.getId());
		}
		LOGGER.info("LifeCycleParticipant::afterSessionEnd(end)");
	}

}
