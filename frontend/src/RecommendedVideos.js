import React from "react";
import "./RecommendedVideos.css";
import VideoCard from "./VideoCard";

function RecommendedVideos() {
  return (
    <div className="recommendedvideos">
      <div className="recommendedVideos__videos">
        <VideoCard
          title="Build a Flutter News App with NewsApi Org | Flutter Tutorial For Beginners"
          views="33k"
          image="./logo.svg"
          channel="Sanskar Tiwari"
          channelImage="./logo.svg"
          timestamp="3 days ago"
          channelUrl="https://www.youtube.com/c/SanskarTiwari"
        />
       
        
      </div>
    </div>
  );
}

export default RecommendedVideos;
