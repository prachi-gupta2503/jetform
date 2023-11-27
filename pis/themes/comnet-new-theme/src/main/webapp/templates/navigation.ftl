<div class="sidebar left-navigation" id="sidebar">
	<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: 100%; height: 577px;">
		<div class="sidebar-inner slimscroll" style="overflow: hidden; width: 100%; height: 577px;">
			<div id="sidebar-menu" class="sidebar-menu">
				<ul>
					<#list nav_items as nav_item>
						<#assign
							nav_item_attr_has_popup = ""
							nav_item_css_class = ""
							nav_item_layout = nav_item.getLayout()
						/>
				
						<#if nav_item.isSelected()>
							<#assign
								nav_item_attr_has_popup = "aria-haspopup='true'"
								nav_item_css_class = "selected"
							/>
						</#if>
				
						<#if nav_item.hasChildren()>
							<li class="menu-title"><span>${nav_item.getName()}</span></a><li>
							
							<#list nav_item.getChildren() as nav_child>
								<#assign
									nav_child_css_class = ""
								/>
				
								<#if nav_item.isSelected()>
									<#assign
										nav_child_css_class = "selected"
									/>
								</#if>
								
								<li class="submenu">
									<#if nav_child.hasChildren()>
										<a href="#">
											<#if nav_child.iconURL()!=''>
												<img src="${nav_child.iconURL()}" style="width:24px; height:24px;"/>
											</#if>
											<span>${nav_child.getName()}</span>
											<span class="menu-arrow"></span>
										</a>
										<ul style="display: none;">
											<#list nav_child.getChildren() as nav_sub_child>
												<#assign
													nav_sub_child_css_class = ""
												/>
					
												<#if nav_child.isSelected()>
													<#assign
														nav_sub_child_css_class = "selected"
													/>
												</#if>
												<li><a href="${nav_sub_child.getURL()}" ${nav_sub_child.getTarget()}>
												<#if nav_sub_child.iconURL()!=''>
													<img src="${nav_sub_child.iconURL()}" style="width:24px; height:24px;"/>
												</#if>
												${nav_sub_child.getName()}</a></li>
											</#list>
										</ul>
									<#else>
										<a href="${nav_child.getURL()}" ${nav_child.getTarget()}><span>${nav_child.getName()}</span></a>
									</#if>
								</li>
								
							</#list>
						<#else>
							<li class="menu-title"> 
								<a href="${nav_item.getURL()}" ${nav_item.getTarget()}><span>${nav_item.getName()}</span></a>
							</li>
						</#if>
					</#list>
				</ul>
			</div>
		</div>
		<div class="slimScrollBar"
			style="background: rgb(204, 204, 204); width: 7px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px; height: 240.981px;"></div>
		<div class="slimScrollRail"
			style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div>
	</div>
</div>	
