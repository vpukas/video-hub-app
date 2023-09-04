import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './CommentSection.css';

function CommentSection({ videoId, token }) {
    const [comments, setComments] = useState([]);
    const [newComment, setNewComment] = useState('');

    // Fetch comments for the video when the component mounts
    useEffect(() => {
        axios
            .get(`http://localhost:8080/api/v1/videos/${videoId}/comments`, {
                headers: {
                    Authorization: 'Bearer ' + token,
                },
            })
            .then((response) => {
                setComments(response.data);
            })
            .catch((error) => {
                console.error('Error fetching comments:', error);
            });
    }, [videoId, token]);

    const handleCommentSubmit = () => {
        // Make an API call to add a new comment
        axios
            .post(
                `http://localhost:8080/api/v1/videos/${videoId}/comments`,
                { text: newComment },
                {
                    headers: {
                        Authorization: 'Bearer ' + token,
                    },
                }
            )
            .then(() => {
                // Refresh the comments by fetching them again
                axios
                    .get(`http://localhost:8080/api/v1/videos/${videoId}/comments`, {
                        headers: {
                            Authorization: 'Bearer ' + token,
                        },
                    })
                    .then((response) => {
                        setComments(response.data);
                    })
                    .catch((error) => {
                        console.error('Error fetching comments:', error);
                    });

                // Clear the input field
                setNewComment('');
            })
            .catch((error) => {
                console.error('Error adding comment:', error);
            });
    };

    return (
        <div className="comment-container">
            <h2 className="comment-heading">Comments</h2>
            <div className="comment-input-container">
                <textarea
                    rows="4"
                    cols="50"
                    className="comment-input"
                    value={newComment}
                    onChange={(e) => setNewComment(e.target.value)}
                    placeholder="Add a comment"
                />
                <button className="comment-submit-button" onClick={handleCommentSubmit}>
                    Submit
                </button>
            </div>
            <ul className="comment-list">
                {comments.map((comment) => (
                    <li className="comment-item" key={comment.id}>
                        <strong>{comment.userName}:</strong> {comment.text}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default CommentSection;
