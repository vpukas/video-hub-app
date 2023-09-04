import React, { useState, useEffect } from "react";
import "./RecommendedVideos.css";
import VideoCard from "./VideoCard";
import axios from 'axios';

function RecommendedVideos() {
  const [token, setToken] = useState(localStorage.getItem('token'));
  const [videos, setVideos] = useState([]);

  const getVideos = () => {
    axios.get('http://localhost:8080/api/v1/videos', {
      headers: {
        Authorization: 'Bearer ' + token
      }
    })
    .then(response => {
      setVideos(response.data);
    });
  };


  useEffect(() => {
    getVideos();
  }, []);

  return (
    <div className="recommendedvideos">
      <div className="recommendedVideos__videos">
        {videos.map((video) => (
          <VideoCard
            key={video.id}
            id={video.id}
            title={video.title}
            views={video.views}
            channel={video.channelName}
            channelImage="./logo.svg"
            channelId={video.channelId}
          />
        ))}
      </div>
    </div>
  );
}

export default RecommendedVideos;
