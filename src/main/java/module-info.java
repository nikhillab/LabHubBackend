/**
 * 
 */
/**
 * @author nikhil
 *
 */
module labHub {
	exports com.labhub;
	exports com.labhub.fileservice;
	exports com.labhub.Controller;
	exports com.labhubEntity;
	exports com.labhub.repo;

	opens com.labhub to spring.core;
	opens com.labhub.fileservice to spring.core;

	requires org.apache.tomcat.embed.core;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.web;
	requires spring.webmvc;
	requires java.persistence;

}