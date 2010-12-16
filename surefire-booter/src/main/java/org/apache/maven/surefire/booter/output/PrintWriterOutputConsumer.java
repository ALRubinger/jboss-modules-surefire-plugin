package org.apache.maven.surefire.booter.output;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.surefire.report.ReportEntry;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * Surefire output consumer that writes everything to a {@link Writer}
 *
 * @author <a href="mailto:carlos@apache.org">Carlos Sanchez</a>
 * @version $Id: PrintWriterOutputConsumer.java 510866 2007-02-23 08:13:49Z brett $
 * @since 2.1
 */
public class PrintWriterOutputConsumer
    implements OutputConsumer
{

    private PrintWriter printWriter;

    /**
     * Create a consumer uninitialized, {@link #setPrintWriter(PrintWriter)} must be called before using it
     */
    public PrintWriterOutputConsumer()
    {
    }

    /**
     * Create a consumer that will write to the specified {@link Writer}
     *
     * @param writer where to write to
     */
    public PrintWriterOutputConsumer( Writer writer )
    {
        this.setPrintWriter( new PrintWriter( writer ) );
    }

    /**
     * Set the {@link PrintWriter} used by this object
     *
     * @param writer
     */
    public void setPrintWriter( PrintWriter writer )
    {
        this.printWriter = writer;
    }

    /**
     * Get the {@link PrintWriter} used by this object
     */
    public PrintWriter getPrintWriter()
    {
        return printWriter;
    }

    public void consumeHeaderLine( String line )
    {
        write( line );
    }

    public void consumeMessageLine( String line )
    {
        write( line );
    }

    public void consumeFooterLine( String line )
    {
        write( line );
    }

    public void consumeOutputLine( String line )
    {
        write( line );
    }

    /**
     * Do nothing
     */
    public void testSetStarting( ReportEntry reportEntry )
    {
        // do nothing
    }

    /**
     * Do nothing
     */
    public void testSetCompleted()
    {
        // do nothing
    }

    /**
     * Write a line and flush
     *
     * @param line
     */
    private void write( String line )
    {
        getPrintWriter().println( line );
        getPrintWriter().flush();
    }

}
