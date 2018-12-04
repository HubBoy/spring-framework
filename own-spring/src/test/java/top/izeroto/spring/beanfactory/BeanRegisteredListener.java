package top.izeroto.spring.beanfactory;

import org.springframework.beans.factory.parsing.*;

public class BeanRegisteredListener implements ReaderEventListener {
	@Override
	public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {
	}

	@Override
	public void componentRegistered(ComponentDefinition componentDefinition) {
		System.out.println(componentDefinition.getName()+"已注册");
	}

	@Override
	public void aliasRegistered(AliasDefinition aliasDefinition) {
		System.out.println(aliasDefinition.getAlias()+"已注册，原名："+aliasDefinition.getBeanName());
	}

	@Override
	public void importProcessed(ImportDefinition importDefinition) {

	}
}
