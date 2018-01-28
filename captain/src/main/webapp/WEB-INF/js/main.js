Media = {

    autoDisplayFlag: true,
    displayInterval: 4000,
    imgSnapDivs: [],
    intervalId: 0,
    currentIndex: 0,
    audioSrcUrlLoveFromOversea: 'audio/love-from-oversea.mp3',
    audioSrcUrlFootprintOfRain: 'audio/footprint-of-rain.mp3',

    displayPhotos: function () {
        var totalDivs = Media.imgSnapDivs.size();
        if(Media.autoDisplayFlag) {
            Media.imgSnapDivs[Media.currentIndex].click();
            Media.currentIndex++;
            if(Media.currentIndex >= totalDivs)
                Media.currentIndex = 0;
        } else {
            clearInterval(Media.intervalId);
        }
    },

    autoDisplay: function () {
        /*
            If you change the src of EMBED, the mp3 won't be loaded
            So, need to append the EMBED by dynamic
        */
        Media.startAudio(Media.audioSrcUrlLoveFromOversea);
        Media.bindEventToStopAutoDisplay();
        Media.imgSnapDivs = $('#bar').find('div');
        Media.intervalId = setInterval(Media.displayPhotos, Media.displayInterval);
    },

    startAudio: function (audioUrl, node) {
        $("#audio-container").children().remove();
        //$('<embed src="' + audioUrl + '" autostart="true" loop="20" width=0 height=0>').appendTo($("#audio-container"));
        $('<embed src="' + audioUrl + '" autostart="true" loop="true" hidden="true"></embed>').appendTo($(node));
        //$('<bgsound src="' + audioUrl + '"autostart=true loop=infinite>').appendTo($("#audio-container"));
    },

    bindEventToStopAutoDisplay: function () {
        $('body').bind('contextmenu', function() {
            if(Media.autoDisplayFlag) {
                Media.autoDisplayFlag = false;
                Media.startAudio(Media.audioSrcUrlFootprintOfRain);
                initPhotoWall();
            }
            return false;
        });
    }

}

Schedule = {

    openPageInSelf: function(link) {
        window.open(link, "_self");
    }

}