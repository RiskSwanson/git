/*

 * The MIT License (MIT)

 *

 * Copyright © 2014-2016, Heiko Brumme

 *

 * Permission is hereby granted, free of charge, to any person obtaining a copy

 * of this software and associated documentation files (the "Software"), to deal

 * in the Software without restriction, including without limitation the rights

 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell

 * copies of the Software, and to permit persons to whom the Software is

 * furnished to do so, subject to the following conditions:

 *

 * The above copyright notice and this permission notice shall be included in all

 * copies or substantial portions of the Software.

 *

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR

 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,

 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE

 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER

 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,

 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE

 * SOFTWARE.

 */

package graphics;



import java.nio.IntBuffer;

import org.lwjgl.glfw.GLFWErrorCallback;

import org.lwjgl.glfw.GLFWKeyCallback;

import org.lwjgl.glfw.GLFWVidMode;

import org.lwjgl.opengl.GL;

import org.lwjgl.system.MemoryUtil;

import map.Chunk;
import map.ChunkFactory;

import static org.lwjgl.glfw.GLFW.*;

import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.system.MemoryUtil.NULL;



/**

 * This class is a simple quick starting guide. This is mainly a java conversion

 * of the

 * <a href=http://www.glfw.org/docs/latest/quick.html>Getting started guide</a>

 * from the official GLFW3 homepage.

 *

 * @author Heiko Brumme

 */

public class Introduction {

	final static float size = 0.2f;

    /**

     * This error callback will simply print the error to

     * <code>System.err</code>.

     */

    private static GLFWErrorCallback errorCallback

                                     = GLFWErrorCallback.createPrint(System.err);



    /**

     * This key callback will check if ESC is pressed and will close the window

     * if it is pressed.

     */

    private static GLFWKeyCallback keyCallback = new GLFWKeyCallback() {



        @Override

        public void invoke(long window, int key, int scancode, int action, int mods) {

            if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {

                glfwSetWindowShouldClose(window, true);

            }

        }

    };



    /**

     * The main function will create a 640x480 window and renders a rotating

     * triangle until the window gets closed.

     *

     * @param args the command line arguments

     */

    public static void main(String[] args) {

        long window =  createWindow();


        /* Declare buffers for using inside the loop */

        IntBuffer width = MemoryUtil.memAllocInt(1);

        IntBuffer height = MemoryUtil.memAllocInt(1);

        
        gameLoop(window, width, height);

        dispose(window, width, height);

        

        

    }
    
    private static void gameLoop(long window, IntBuffer width, IntBuffer height){
    	CubeFactory cf = new CubeFactory();
    	
    	float x = 0.0f;
    	/* Loop until window gets closed */
    	while (!glfwWindowShouldClose(window)) {
        	

    		glLoadIdentity();
    		
    		init(window, width, height);
    		
            /* Rotate matrix */
    		glRotatef((float) glfwGetTime() * 50f, 1f, 1f, 0.5f);
    		x = input (window, x);
            
            ChunkFactory cf2 = new ChunkFactory();
            Chunk c = cf2.createChunk(1, 1, 1, 0, 0, 0);
            cf.createCube(c);
            Chunk c2 = cf2.createChunk(1, 1, 1, 1, 0, 0);
            cf.createCube(c2);
            Chunk c3 = cf2.createChunk(1, 1, 1, 0, 1, 0);
            cf.createCube(c3);
        	
           

            /* Swap buffers and poll Events */

            glfwSwapBuffers(window);

            glfwPollEvents();



            /* Flip buffers for next loop */

            width.flip();

            height.flip();

        }
    }
    
    private static void dispose(long window, IntBuffer width, IntBuffer height){
    	/* Free buffers */
    	
    	MemoryUtil.memFree(width);

        MemoryUtil.memFree(height);



        /* Release window and its callbacks */

        glfwDestroyWindow(window);

        keyCallback.free();



        /* Terminate GLFW and release the error callback */

        glfwTerminate();

        errorCallback.free();
    }
    
    private static long createWindow(){
    	long window;
    	
    	/* Set the error callback */

        glfwSetErrorCallback(errorCallback);



        /* Initialize GLFW */

        if (!glfwInit()) {

            throw new IllegalStateException("Unable to initialize GLFW");

        }



        /* Create window */

        window = glfwCreateWindow(640, 480, "Simple example", NULL, NULL);

        if (window == NULL) {

            glfwTerminate();

            throw new RuntimeException("Failed to create the GLFW window");

        }



        /* Center the window on screen */

        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(window,

                         (vidMode.width() - 640) / 2,

                         (vidMode.height() - 480) / 2

        );



        /* Create OpenGL context */

        glfwMakeContextCurrent(window);

        GL.createCapabilities();

        glEnable(GL_DEPTH_TEST);

        /* Enable vertical synchronization */

        glfwSwapInterval(1);



        /* Set the key callback */

        glfwSetKeyCallback(window, keyCallback);
        
        return window;
    }
    
    private static float input(long window, float x){
    	int state = glfwGetKey(window, GLFW_KEY_RIGHT);
        if (state == GLFW_PRESS) {
            x+=0.02f;
        }
        
        state = glfwGetKey(window, GLFW_KEY_LEFT);
        if (state == GLFW_PRESS) {
            x-=0.02f;
        }
        
        return x;
    }
    
    private static void init(long window, IntBuffer width, IntBuffer height){
    	float ratio;



        /* Get width and height to calculate the ratio */

        glfwGetFramebufferSize(window, width, height);

        ratio = width.get() / (float) height.get();



        /* Rewind buffers for next get */

        width.rewind();

        height.rewind();



        /* Set viewport and clear screen */
        
        glViewport(0, 0, width.get(), height.get());

        glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);



        /* Set ortographic projection */

        glMatrixMode(GL_PROJECTION);

        glLoadIdentity();

        glOrtho(-ratio, ratio, -1f, 1f, 1f, -1f);

        glMatrixMode(GL_MODELVIEW);

    	
    }

    public static void RenderCube(){
    	/* Render cube */

        glBegin(GL_TRIANGLES);
        float x = 0.5f;
        float y = 0.5f;
        float z = 0.5f;
        
        //side one
        glColor3f(1.0f,1.0f,0.0f);           
        glVertex3f( x + size, y+size,z-size);        
        glVertex3f( x -size, y+size,z-size);        
        glVertex3f( x-size, y+size,z+ size);
        
        glVertex3f( x+ size, y+size, z+size);
        glVertex3f( x+size,y+ size,z-size);        
        glVertex3f(z-size,y+ size,z+ size);
        
        //side two
        glColor3f(1.0f,0.5f,0.0f);            
        glVertex3f(x+ size,y-size,z+ size);
        glVertex3f(x-size,y-size, z+size);
        glVertex3f(x-size,y-size,z-size);
        
        glVertex3f(x+ size,y-size,z+ size);
        glVertex3f(x-size,y-size,z-size);
        glVertex3f( x+size,y-size,z-size);
        
        //side three
        glColor3f(1.0f,0.0f,0.0f);
        glVertex3f( x+size,y+ size,z+ size);
        glVertex3f(x-size, y+size, z+size);
        glVertex3f(x-size,y-size, z+size);
        
        glVertex3f(x+ size,y-size,z+ size);
        glVertex3f(x+ size, y+size,z+ size);
        glVertex3f(x-size,y-size,z+ size);
        
        //side four -
        glColor3f(1.0f,1.0f,0.5f);
        glVertex3f(x+ size,y-size,z-size);
        glVertex3f(x-size,y-size,z-size);
        glVertex3f(x-size,y+ size,z-size);
        
        glVertex3f( x+size,y-size,z-size);
        glVertex3f(x-size,y+ size,z-size);
        glVertex3f(x+ size,y+ size,z-size);
        
        //side five 
        glColor3f(0.0f,0.0f,1.0f);
        glVertex3f(x-size, y+size,z+ size);
        glVertex3f(x-size, y+size,z-size);
        glVertex3f(x-size,y-size,z-size);
        
        glVertex3f(x-size,y+ size,z+ size);
        glVertex3f(x-size,y-size,z-size);
        glVertex3f(x-size,y-size,z+ size);
        
        //side six
        glColor3f(1.0f,0.0f,1.0f);
        glVertex3f(x+ size, y+size,z-size);
        glVertex3f(x+ size,y+ size, z+size);
        glVertex3f(x+ size,y-size, z+size);
        
        glVertex3f(x+ size,y+ size,z-size);
        glVertex3f(x+ size,y-size,z+ size);
        glVertex3f(x+ size,y-size,z-size);

        glEnd();
    }

    public static void RenderDiamond(float x, float y, float z){
    	/* Render cube */

        glBegin(GL_TRIANGLES);
        float point = 0.866f * size;
        float recalculatedSize = 1.732f*size;
        
        //top one
        glColor3f(1.0f,0.0f,0.0f);
        glVertex3f( x+recalculatedSize,y+ size,z+ size);
        glVertex3f(x-recalculatedSize, y+size, z+size);
        glVertex3f(x-recalculatedSize,y-size, z+size);
        
        glVertex3f(x+ recalculatedSize,y-size,z+ size);
        glVertex3f(x+ recalculatedSize, y+size,z+ size);
        glVertex3f(x-recalculatedSize,y-size,z+ size);
        
        glVertex3f(x+recalculatedSize, y+size, z+size);
        glVertex3f(x, y+size+point, z+size);
        glVertex3f(x-recalculatedSize, y+size, z+size);
        
        glVertex3f(x+recalculatedSize, y-size, z+size);
        glVertex3f(x, y-size-point, z+size);
        glVertex3f(x-recalculatedSize, y-size, z+size);
        
      //bottom two
        glColor3f(1.0f,0.0f,0.0f);
        glVertex3f( x+recalculatedSize,y+ size,z- size);
        glVertex3f(x-recalculatedSize, y+size, z-size);
        glVertex3f(x-recalculatedSize,y-size, z-size);
        
        glVertex3f(x+ recalculatedSize,y-size,z- size);
        glVertex3f(x+ recalculatedSize, y+size,z- size);
        glVertex3f(x-recalculatedSize,y-size,z- size);
        
        glVertex3f(x+recalculatedSize, y+size, z-size);
        glVertex3f(x, y+size+point, z-size);
        glVertex3f(x-recalculatedSize, y+size, z-size);
        
        glVertex3f(x+recalculatedSize, y-size, z-size);
        glVertex3f(x, y-size-point, z-size);
        glVertex3f(x-recalculatedSize, y-size, z-size);
        
        //side three
        glColor3f(0.0f,1.0f,0.0f);
        glVertex3f( x-recalculatedSize,y+ size,z+ size);
        glVertex3f(x-recalculatedSize, y+size, z-size);
        glVertex3f(x-recalculatedSize,y-size, z-size);
        
        glVertex3f(x- recalculatedSize,y-size,z+ size);
        glVertex3f(x- recalculatedSize, y+size,z+ size);
        glVertex3f(x-recalculatedSize,y-size,z- size);
        

        //side four
        glColor3f(0.0f,1.0f,0.0f);
        glVertex3f( x+recalculatedSize,y+ size,z+ size);
        glVertex3f(x+recalculatedSize, y+size, z-size);
        glVertex3f(x+recalculatedSize,y-size, z-size);
        
        glVertex3f(x+ recalculatedSize,y-size,z+ size);
        glVertex3f(x+ recalculatedSize, y+size,z+ size);
        glVertex3f(x+recalculatedSize,y-size,z- size);
        
        //side five
        glColor3f(0.0f,0.0f,1.0f);
        glVertex3f( x+recalculatedSize,y+size,z+ size);
        glVertex3f(x, y+size+point, z+size);
        glVertex3f(x+recalculatedSize,y+size, z-size);
        
        glVertex3f( x+recalculatedSize,y+size,z- size);
        glVertex3f(x, y+size+point, z+size);
        glVertex3f(x,y+size+point, z-size);
        
        //side six
        glColor3f(0.0f,0.0f,1.0f);
        glVertex3f( x-recalculatedSize,y-size,z+ size);
        glVertex3f(x, y-size-point, z+size);
        glVertex3f(x-recalculatedSize,y-size, z-size);
        
        glVertex3f( x-recalculatedSize,y-size,z- size);
        glVertex3f(x, y-size-point, z+size);
        glVertex3f(x,y-size-point, z-size);
        
      //side seven
        glColor3f(0.0f,1.0f,1.0f);
        glVertex3f( x+recalculatedSize,y-size,z+ size);
        glVertex3f(x, y-size-point, z+size);
        glVertex3f(x+recalculatedSize,y-size, z-size);
        
        glVertex3f( x+recalculatedSize,y-size,z- size);
        glVertex3f(x, y-size-point, z+size);
        glVertex3f(x,y-size-point, z-size);
        
        //side five
        glColor3f(0.0f,1.0f,1.0f);
        glVertex3f( x-recalculatedSize,y+size,z+ size);
        glVertex3f(x, y+size+point, z+size);
        glVertex3f(x-recalculatedSize,y+size, z-size);
        
        glVertex3f( x-recalculatedSize,y+size,z- size);
        glVertex3f(x, y+size+point, z+size);
        glVertex3f(x,y+size+point, z-size);
        
        /*
        glVertex3f(x+size,y+size,z+ size);
        glVertex3f(x+(size/2), y+size+point,z+ size);
        glVertex3f(x+size,y+size+point,z- size);
        */
        
        glEnd();
    }

}