package org.growler

class Presentation {

    String title
    String abstractText
    String summary
    String presentationType
    String targetAudience
    int lengthMinutes
    Date dateCreated
    Date lastUpdate
    String lastUpdatedBy


    static hasMany = [videos: Video, files: StorageDesc, materialsNeeded: Item]

    static mappings = {
    }

    static constraints = {
        title blank:false, maxSize:256
        abstractText blank: false, maxSize: 1024
        summary blank: false, maxSize: 2048
        presentationType inlist: [
            "WORKSHOP",
            "PANEL_DISCUSSION",
            "LECTURE"
        ]
        targetAudience blank: false, maxSize: 32
        lengthMinutes range: 0..240
        dateCreated nullable: true, display: false
        lastUpdate nullable: true, display: false
        lastUpdatedBy nullable: true, display: false
    }

    static belongsTo = [event:Event,speaker:Speaker]


//    def beforeUpdate() {
//        lastUpdatedBy = securityService.currentAuthenticatedUsername()
//    }
}
