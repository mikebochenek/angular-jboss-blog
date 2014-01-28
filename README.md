JBoss & Angular JS
----------------------

	cd ~/Dev/workspace/angular-jboss-blog
	http://localhost:8080/jboss-as-kitchensink-angularjs/

	mvn clean package jboss-as:deploy
	mvn clean package jboss-as:redeploy

	mvn clean package jboss-as:deploy
	mvn jboss-as:undeploy
	mvn clean test -Parq-jbossas-remote 
    mvn dependency:sources
    mvn dependency:resolve -Dclassifier=javadoc
