import {useEffect, useRef} from 'react';
import api from '../../api/axios';
import {useParams} from 'react-router-dom';
import {Container, Row, Col} from 'react-bootstrap';
import ReviewForm from '../reviewForm/ReviewForm';

import React from 'react'

const Reviews = ({getMovieData,movie,reviews,setReviews}) => {

    const revText = useRef();
    let params = useParams();
    
    const movieId = params.movieId;
   
    useEffect(()=>{
        getMovieData(movieId);
    },[])

    const addReview = async (e) =>{
        e.preventDefault();
        const rev = revText.current
        console.log(rev.value)
        

        try
        {
            const response = await api.post("/api/v1/reviews",{body:rev.value,imdbId:movieId});

            const updatedReviews =
        reviews != null
          ? [...reviews, { body: rev.value }]
          : [{ body: rev.value }];
    
            rev.value = "";
    
            setReviews(updatedReviews);
        }
        catch(err)
        {
            console.error(err);
        }
        



    }

  return (
    <Container style={{position: "relative",    
        top: "40px",height:"100vh",overflow:"hidden"}}>
        <Row>
            <Col><h3>Reviews</h3></Col>
        </Row>
        <Row className="mt-2" >
            <Col >
                <img src={movie?.poster} alt="" style={{height:"80%"}} />
            </Col>
            <Col >
                {
                    <>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview} revText={revText} labelText = "Write a Review?" />  
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <hr />
                            </Col>
                        </Row>
                    </>
                }
                {
                    reviews?.map((r) => {
                        return(
                            <>
                                <Row>
                                    <Col>{r.body}</Col>
                                </Row>
                                <Row>
                                    <Col>
                                        <hr />
                                    </Col>
                                </Row>                                
                            </>
                        )
                    })
                }
            </Col>
        </Row>
        <Row>
            <Col>
                <hr />
            </Col>
        </Row>        
    </Container>
  )
}

export default Reviews