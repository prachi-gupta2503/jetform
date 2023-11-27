<div class="dashboard-layout" id="main-content" role="main">
	
	<div style="width:50%;margin-left:25%;">
		<div class="input-group mt-3">
			<input type="text" class="form-control" placeholder="Search in option">
			<div class="input-group-append">
				<button class="btn btn-secondary" type="button">
					<i class="fa fa-search"></i>
				</button>
			</div>
		</div>
	</div>
		
	<div class="portlet-layout row mt-1">
		<div class="col-md-3 portlet-column portlet-column-first" id="column-1">
			${processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-3 portlet-column" id="column-2">
			${processor.processColumn("column-2", "portlet-column-content ")}
		</div>
		
		<div class="col-md-3 portlet-column" id="column-3">
			${processor.processColumn("column-3", "portlet-column-content ")}
		</div>
		
		<div class="col-md-3 portlet-column portlet-column-last" id="column-4">
			${processor.processColumn("column-4", "portlet-column-content portlet-column-content-last")}
		</div>
	</div>
	
	<div class="portlet-layout row mt-1">
		<div class="col-md-4 portlet-column portlet-column-first" id="column-5">
			${processor.processColumn("column-5", "portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-4 portlet-column" id="column-6">
			${processor.processColumn("column-6", "portlet-column-content ")}
		</div>
		
		<div class="col-md-4 portlet-column portlet-column-last" id="column-7">
			${processor.processColumn("column-7", "portlet-column-content ")}
		</div>
	</div>
	
	<div class="portlet-layout row mt-1">
		<div class="col-md-6 portlet-column portlet-column-first" id="column-8">
			${processor.processColumn("column-8", "portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-3 portlet-column" id="column-9">
			${processor.processColumn("column-9", "portlet-column-content")}
		</div>
		
		<div class="col-md-3 portlet-column portlet-column-last" id="column-10">
			${processor.processColumn("column-10", "portlet-column-content")}
		</div>
	</div>	
	
	<div class="portlet-layout row mt-1">
		<div class="col-md-3 portlet-column portlet-column-first" id="column-11">
			${processor.processColumn("column-11", "portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-3 portlet-column" id="column-12">
			${processor.processColumn("column-12", "portlet-column-content")}
		</div>
		
		<div class="col-md-6 portlet-column portlet-column-last" id="column-13">
			${processor.processColumn("column-13", "portlet-column-content")}
		</div>
	</div>	
	
	<div class="portlet-layout row mt-1">
		<div class="col-md-3 portlet-column portlet-column-first" id="column-14">
			${processor.processColumn("column-14", "portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-6 portlet-column" id="column-15">
			${processor.processColumn("column-15", "portlet-column-content")}
		</div>
		
		<div class="col-md-3 portlet-column portlet-column-last" id="column-16">
			${processor.processColumn("column-16", "portlet-column-content")}
		</div>
	</div>	
	
	<div class="portlet-layout row mt-1">
		<div class="col-md-3 portlet-column portlet-column-first" id="column-17">
			${processor.processColumn("column-17", "portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-3 portlet-column" id="column-18">
			${processor.processColumn("column-18", "portlet-column-content")}
		</div>
		
		<div class="col-md-3 portlet-column" id="column-19">
			${processor.processColumn("column-19", "portlet-column-content")}
		</div>
		
		<div class="col-md-3 portlet-column portlet-column-last" id="column-20">
			${processor.processColumn("column-20", "portlet-column-content portlet-column-content-last")}
		</div>
		
	</div>

	<div class="portlet-layout row mt-1">
		<div class="col-md-6 portlet-column portlet-column-first" id="column-21">
			${processor.processColumn("column-21", "portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-6 portlet-column portlet-column-last" id="column-22">
			${processor.processColumn("column-22", "portlet-column-content portlet-column-content-last")}
		</div>
		
	</div>
	
</div>