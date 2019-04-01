using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class controller : MonoBehaviour
{
    [HideInInspector]
    public bool isJump = false;
    [HideInInspector]
    public bool isGrounded = false;
    [HideInInspector]
    public bool isFacingRight = true;

    public Transform groundCheck;
    public LayerMask groundLayers;
    public float groundCheckRadius = 0.2f;

    public Animator anim;
    public float jumpForce = 700.0f;
    public float Speed = 7.0f;
    //public anim

    void Update()
    {
         if(Input.GetAxisRaw("Horizontal")!=0)
        {
            anim.SetBool("isWalk",true);
        }
        if(Input.GetButtonDown("Jump"))
        {
            if(isGrounded)
            {
                this.GetComponent<Rigidbody2D>().velocity = new Vector2(GetComponent<Rigidbody2D>().velocity.x, 0);
                this.GetComponent<Rigidbody2D>().AddForce(new Vector2(0, jumpForce));
            }
        }

    }

    void FixedUpdate()
    {
        float move = Input.GetAxis("Horizontal");
        GetComponent<Rigidbody2D>().velocity = new Vector2(move * Speed, GetComponent<Rigidbody2D>().velocity.y);
        isGrounded = Physics2D.OverlapCircle(groundCheck.position, groundCheckRadius, groundLayers);
        
        anim.SetBool("isWalk",false);
        
        if((move > 0.0f && !isFacingRight) || (move < 0.0f && isFacingRight))
        {
            Flip();
        }
    }

    void Flip()
    {
        isFacingRight = !isFacingRight;
        Vector3 playerScale = transform.localScale;
        playerScale.x = playerScale.x * -1;
        transform.localScale = playerScale;
    }
}
