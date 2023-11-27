<div class="header-top">
   <div class="container-fluid">
      <div class="row">
         <div class="col-md-4">
              <div class="header-right-div">
                 <ul class="list-inline mb-0">
				  <li class="list-inline-item"><a href="#content">
				  
				  <a href="javascript:void(0);">Theme : </a>
				  <a class="dark-theme-button mr-1" href="javascript:void(0);">A</a>
				  <a class="light-theme-button mr-1" href="javascript:void(0);">A</a>
				  
				  </li>
				  <#assign currentTime  = .now /> 
				  
				  <li class="list-inline-item"><a href="javascript:void(0);"> ${currentTime}</a></li>
				   
				</ul>
            </div>
         </div>
         <div class="col-md">
            <div class="header-right-div text-right">
                 <ul class="list-inline mb-0">
                 <li class="list-inline-item"><a href="javascript:void(0);"><i class="fas fa-volume-up mr-1"></i> Screen Reader</a></li>
				  <li class="list-inline-item"><a href="#content"><i class="fas fa-play"></i> Skip To Main Content</a></li>
				  <li class="list-inline-item">
				  <a href="javascript:void(0);">Text Size : </a>
				  <a id="fontIncrease" href="javascript:void(0);">A<sup style="font-size: 14px;">+</sub></a>
				  <a id="fontDefault" href="javascript:void(0);">A</a>
				  <a id="fontDecrease" href="javascript:void(0);">A<sup style="font-size: 14px;">-</sup></a>
				  </li>

				  <li class="list-inline-item"><a href="javascript:void(0);"> Language : 
				    <select name="Language" class="font-selection">
						<option selected value="english">English</option>
						<option value="hindi">हिन्दी</option>
					</select>
				   </a>
				  </li>
				</ul>
            </div>
         </div>
      </div>
   </div>
</div>
