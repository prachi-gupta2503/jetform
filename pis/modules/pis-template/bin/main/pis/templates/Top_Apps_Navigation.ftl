<div class="row">
    <div class="col"></div>
    <#if entries?has_content>
        <#list entries as appEntry>
            <div class="col">
                <!--<div class="text-center hover-css mb-2 p-2">
                    <a href="${appEntry.getURL()}" target="_blank">
                        <div class="service-icon mb-2">
                            <img src="${appEntry.iconURL()}" alt=""/>
                        </div>
                        <div class="service-title">
                            ${appEntry.getName()}
                        </div>
                    </a>
                </div>-->
                <div class="text-center hover-css p-2">
                    <a href="${appEntry.getURL()}" target="_blank">
                        <div class="service-icon">
                            <img src="${appEntry.iconURL()}" alt="${appEntry.getName()}" style="width:30px; height:auto;" title="${appEntry.getName()}"/>
                        </div>
                        <!--<div class="service-title">
                            ${appEntry.getName()}
                        </div>-->
                    </a>
                </div>
            </div>
        </#list>
    </#if>
</div>