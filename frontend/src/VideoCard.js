import React from "react";
import { Avatar } from "@mui/material/";
import "./VideoCard.css";

function VideoCard({
  image,
  title,
  channel,
  views,
  timestamp,
  channelImage,
  channelUrl,
}) {
  return (
    <div className="videoCard">
      <img className="videoCard__thumbnail" src={image} alt="" />
      <div className="videoCard__info">
        <Avatar
          className="videoCard__avatar"
          alt={channel}
          src={channelImage}
        />
        <div className="video__text">
          <p style={{ fontSize: "14px", color: "#d9d9d9" }}>{title}</p>
          <p style={{ fontSize: "13px", marginTop: "4px", toolTip: "Hello", color: "#d9d9d9" }}>
            <a style={{ fontFeatureSettings: "normal", color: "#d9d9d9" }} href={channelUrl}>
              {channel}
            </a>
          </p>
          <p style={{ marginTop: "3px", fontSize: "12px", color: "#d9d9d9" }}>
            {`${views} views`} • {timestamp}
          </p>
        </div>
      </div>
    </div>
  );
}

export default VideoCard;
