package org.myaddon.commands;

import javax.inject.Inject;

import org.jboss.forge.addon.ui.command.AbstractUICommand;
import org.jboss.forge.addon.ui.context.UIBuilder;
import org.jboss.forge.addon.ui.context.UIContext;
import org.jboss.forge.addon.ui.context.UIExecutionContext;
import org.jboss.forge.addon.ui.input.UIInput;
import org.jboss.forge.addon.ui.metadata.UICommandMetadata;
import org.jboss.forge.addon.ui.metadata.WithAttributes;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;
import org.jboss.forge.addon.ui.util.Metadata;

public class HelloWorld extends AbstractUICommand {

	@Inject
	@WithAttributes(label = "Your Name", required = true)
	private UIInput<String> name;

	@Override
	public UICommandMetadata getMetadata(UIContext context) {
		return Metadata.forCommand(HelloWorld.class).name("HelloWorld");
	}

	@Override
	public void initializeUI(UIBuilder builder) throws Exception {
		builder.add(name);
	}

	@Override
	public Result execute(UIExecutionContext context) {
		return Results.success("Hello " + name.getValue());
	}
}