import React, { useState, useEffect } from "react";
import "./RecommendedVideos.css";
import VideoCard from "./VideoCard";
import axios from 'axios';

function RecommendedVideos() {
  const [token, setToken] = useState('eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZXIzQGdtYWlsLmNvbSIsImlhdCI6MTY4NTAyMTkxOSwiZXhwIjoxNjg1MDIzMzU5fQ.FGiApsRzcLNeqZYmgNykfHl7trxfP0Zsv_cc_pfp7ho');
  const [videos, setVideos] = useState([]);

  const getVideos = () => {
    axios.get('api/v1/videos', {
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
            image="./logo.svg"
            channel={video.chanelName}
            channelImage="./logo.svg"
            channelUrl=""
          />
        ))}
      </div>
    </div>
  );
}

export default RecommendedVideos;
